package APT201;

public class Internet {
        boolean[] visited = new boolean[50];
        int removed_router;

        void search(int current, String[] routers)
        {
            if (visited[current]) return;
            if (current==removed_router) return;
            visited[current]=true;
            String[] links=routers[current].split(" ");
            for(int i=0;i<links.length;i++)
                search(Integer.parseInt(links[i]),routers);
        }

        public int articulationPoints(String[] routers) { 
                search(0, routers);
                return removed_router;
        }
}
