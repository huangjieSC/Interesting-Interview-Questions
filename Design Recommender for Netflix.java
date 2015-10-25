class User{ 
    int uId;
    Set viewed, liked, disliked;
    int activeScore; 
    
    List recomMovies(){ 
      Map score; 
      for (movie : liked) { 
          for ( user : movie.likedBy ) { 
              if (score.containsKey(user.uId)) 
                  score.put(user.uId, score.get(user.uId) + 1); 
              else score.put(user.uId, 1); 
          } 
      } 
    //  user heap to find top 10 similar users other than itself; 
      List ret; 
      for(user : heap) { 
          for (mId : user.liked) { 
              if (!this.viewed.contains(mId)) 
                ret.add(mId); 
          } 
      } 
      return mId; 
  } 
}


class Moive{ 
    int mId; 
    Set viewedBy, likedBy, dislikedBy; 
    boolean update(List activeUsers){ 
        clear viewedBy, likedBy, dislikedBy; 
        for(user : activeUsers) { 
            if ( user.viewed.contains(this.mId)){
                viewedBy.add(user.uId); 
                if (user.liked.contains(thi.mId)) { 
                    likedBy.add(user.uId); 
                } 
                else 
                    dislikedBy.add(user.uId); 
            } 
        } 
    } 
}

/**
 * To recommend movies for each user, its O(kn) in time complexity, k is movies liked by this user, n is 10,000, 
 * in average its about 1 million operations, so it should take about 0.2 second for each recommendation. 
 * movies are updated only once a day. assume 1 million daily active users, each user watch 1.5 movies a day 
 * (only update recommend list after user watch a new movie). average recom per second = 1million * 1.2 
 * (20% load increase in 3 months) * 1.5 / 86400 = 21 /s peak recomm per second 
 * = 21*20 = 420 /s (heavy traffice in the night) suppose we have 8 core machine, 
 * each machine can process 40 request per second, we will need 11-15 app machines.

we also need a load balancer to distribute the request evenly to each app machine.

we can use mysql as database since data is only updated once a day for movies and 420 /s for the user data. 
To speed up the calculation, we can load all movies data to memory, but only cache recently active user's data.

to increase the availability, we can have backup databases and two load balancers. 
We could also utilize a log machine to monitor all machine's status and change the routing rules in the 
load balancer when failure is detected.
 * /
