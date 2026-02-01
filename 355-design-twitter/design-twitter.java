class Twitter {
    int time = 0;

    class Twit{
        int tid;
        int ts;

        Twit(int tid) {
            this.tid = tid;
            ts = time++;
        }
    }

    class User{
        int uid;
        Set<Integer> following;
        List<Twit> tweets;

        User(int uid) {
            following = new HashSet<>();
            following.add(uid);
            this.uid = uid;
            tweets = new ArrayList<>();
        }

        void follow(int id) {
            following.add(id);
        }

        void unfollow(int id) {
            following.remove(id);
        }
        void tweet(int tid) {
            tweets.add(new Twit(tid));
        }
    }

    Map<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId));
        users.get(userId).tweet(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        users.putIfAbsent(userId, new User(userId));
        PriorityQueue<Twit> pq = new PriorityQueue<>((a, b) -> a.ts - b.ts);
        for (int uid: users.get(userId).following) {
            List<Twit> tweets = users.get(uid).tweets;
            for (Twit twit: tweets) {                
                if (pq.size() < 10) pq.offer(twit);
                else {
                    if (twit.ts >= pq.peek().ts) {
                        pq.offer(twit);
                        pq.poll();
                    }
                }
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().tid);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        users.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */