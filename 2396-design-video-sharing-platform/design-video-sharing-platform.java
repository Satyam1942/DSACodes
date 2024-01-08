class VideoObject
{
    String video;
    int likes;
    int dislikes;
    int views;
    VideoObject(String video,int likes,int dislikes,int views)
    {
        this.video = video;
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
    }

    int getLikes(){return likes;}
    void setLikes(){likes++;}

     int getDislikes(){return dislikes;}
    void setDislikes(){dislikes++;}

     int getViews(){return views;}
    void setViews(){views++;}
}

class VideoSharingPlatform {
    HashMap<Integer,VideoObject> database;
    PriorityQueue<Integer> reusableVideoId ;

    public VideoSharingPlatform() {
        database= new HashMap<>();
        reusableVideoId = new PriorityQueue<>();
    }
    
    public int upload(String video) {
        VideoObject obj = new VideoObject(video,0,0,0);
        int id = 0;

        if(reusableVideoId.isEmpty())  id = database.size();
        else id = reusableVideoId.poll();

        database.put(id,obj);
        return id;
    }
    
    public void remove(int videoId) {
        if(database.containsKey(videoId))
        {
        database.remove(videoId);
        reusableVideoId.add(videoId);
        }
    }
    
    public String watch(int videoId, int startMinute, int endMinute) {
        if(database.containsKey(videoId))
        {
            VideoObject obj = database.get(videoId);
            obj.setViews();
            String video = obj.video;
            return video.substring(startMinute,Math.min(endMinute, video.length() - 1)+1);
        }else return "-1";
    }
    
    public void like(int videoId) {
        if(database.containsKey(videoId))
        {
            VideoObject obj = database.get(videoId);
            obj.setLikes();
        }
    }
    
    public void dislike(int videoId) {
        if(database.containsKey(videoId))
        {
            VideoObject obj = database.get(videoId);
            obj.setDislikes();
        }
    }
    
    public int[] getLikesAndDislikes(int videoId) {
        if(database.containsKey(videoId))
        {
            VideoObject obj = database.get(videoId);
            int info[] = new int[2];
            info[0]= obj.getLikes();
            info[1]= obj.getDislikes();
            return info;
        }else 
        {
            int err[] = new int[1];
            err[0]=-1;
            return err;
        }
    }
    
    public int getViews(int videoId) {
        if(database.containsKey(videoId))
        {
            VideoObject obj = database.get(videoId);
            int views = obj.getViews();
            return views;
        }else return -1;
    }
}

/**
 * Your VideoSharingPlatform object will be instantiated and called as such:
 * VideoSharingPlatform obj = new VideoSharingPlatform();
 * int param_1 = obj.upload(video);
 * obj.remove(videoId);
 * String param_3 = obj.watch(videoId,startMinute,endMinute);
 * obj.like(videoId);
 * obj.dislike(videoId);
 * int[] param_6 = obj.getLikesAndDislikes(videoId);
 * int param_7 = obj.getViews(videoId);
 */