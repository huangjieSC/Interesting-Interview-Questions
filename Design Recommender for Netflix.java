class User{ 
    int uId;
    enum Set{viewed, liked, disliked;}
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
    enum Set {viewedBy, likedBy, dislikedBy}; 
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

