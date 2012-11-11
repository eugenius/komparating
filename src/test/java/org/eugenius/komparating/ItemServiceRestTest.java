package org.eugenius.komparating;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import java.io.File;
import java.net.URL;
import java.util.UUID;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.put;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;

/**
 * @author Eugenius
 */
@RunWith(Arquillian.class)
@RunAsClient
public class ItemServiceRestTest {
    private static final String RESOURCE_PREFIX = JaxRsActivator.class.getAnnotation(ApplicationPath.class).value();
    private static final String SERVICE_SUFFIX = ItemRest.class.getAnnotation(Path.class).value();

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "komparating.war")
                .addPackages(true, "org.eugenius.komparating")
                .addAsResource("META-INF/persistence.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"));
    }

    @ArquillianResource
    URL deploymentUrl;

    @Test
    public void testInitialListOfItemsIsEmpty() throws Exception {
        expect().body("items", empty()).when().get(rootServiceUrl());
    }

    @Test
    public void testPutItemIsListedInGeneralList() throws Exception {
        String itemId = UUID.randomUUID().toString();
        put(serviceUrl("{itemId}"), itemId);
        expect().body("items.guid", hasItem(itemId)).when().get(rootServiceUrl());
    }

    private String serviceUrl(String suffix) {
        return slashEnded(rootServiceUrl()) + suffix;
    }

    private String rootServiceUrl() {
        return slashEnded(deploymentUrl.toString()) + slashEnded(RESOURCE_PREFIX) + SERVICE_SUFFIX;
    }

    private String slashEnded(String url) {
        if (url.endsWith("/")) {
            return url;
        }
        return url + "/";
    }
}
