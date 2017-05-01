Although I didn't get the program working as intended, I feel like what I do have will show how I am always willing to think outside the box. I always like to come up with new ways to do things, and I thought it would be a cool idea to keep track of a "character map" that shows whether it was a strike, spare, or a normal frame. As the weekend came to an end, I figured out some things that I would have definitely done differently if I had enough time to start over again. But nevertheless, it was an interesting project that I had a lot of fun working on, and i'm already thinking of how I can change it up. 

To use my program, it will loop through the ten frames asking for what the score was for each roll, if the roll was a strike, it will automatically take the user to the next frame, to represent a strike you will use the "X" or "x" (it will test for both)

If in any round, the sum of the two rolls adds up to 10, it will automatically be represented as a "/" on the character map. 

Finally if in any round, the user just has two normal rolls, nothing special, it will add the sum of the two numbers, and then add that value to the scoreMap. 


Something I did in this that I thought was pretty interesting, was I used a "somewhat factory" design pattern where all of the object creation (scoreCard) was hidden from he client, this way, the only thing the client had to worry about was creating and using the object for "bowling a round".

The second thing that I did that I thought was pretty interesting, although it proved to be a problem towards the end, was I created a character map, and a score map. I used the score map to keep track of strikes (X) spares (/) and normal rounds (-). This made it easy to find the score using a series of conditionals. 


TODO:: 

- Need to finish the final frame, to make sure it can handle 3 balls instead of two.  
- Might want to be able to handle multiple bowlers per lane 



