komparating
===========

The main idea is that comparing items one-to-one ("first is better than second") is much more natural than rating items by some scale (1 to 10, or any other). So you can compare items one-to-one, then this service will rate all items automatically by any scale you want. Rate scores can be distributed either evenly or by Gaussians.

Example: Let's say we have books "Ender's Game", "The Lord of the Rings" and "Cryptonomicon". And let's say we want to rate them from 1 to 10 (e.g. for some recommendation system). Then we should say to komparating service that "Cryptonomicon" is "better" (actually, we like it more) than "The Lord of the Rings", and "Ender's Game" is "better" than "Cryptonomicon". Komparating will calculate all our comparitions and will say that "The Lord of the Rings" has rating 1, "Cryptonomicon" has rating 5 and "Ender's Game" has rating 10.

I plan to make Komparating RESTful, using JSON.