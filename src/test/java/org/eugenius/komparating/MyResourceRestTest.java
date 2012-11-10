package org.eugenius.komparating;

import org.jboss.arquillian.api.ArquillianResource;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import java.io.File;
import java.net.URL;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Eugenius
 */
@RunWith(Arquillian.class)
@RunAsClient
public class MyResourceRestTest {
    private static final String RESOURCE_PREFIX = JaxRsActivator.class.getAnnotation(ApplicationPath.class).value();
    private static final String SERVICE_SUFFIX = MyResource.class.getAnnotation(Path.class).value();

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "komparating.war")
                .addPackages(true, "org.eugenius.komparating")
//                .addAsResource("META-INF/persistence.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"));
    }

    @ArquillianResource
    URL deploymentUrl;

    @Test
    public void testGetIt() throws Exception {
        expect().body(equalTo("Hi there!")).when().get(deploymentUrl.toString() + RESOURCE_PREFIX + "/" + SERVICE_SUFFIX);
    }
}
