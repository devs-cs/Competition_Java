import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CyclicMol {
    private static int n;
    private static int m;
    private static ArrayList<Integer>[] edges;
    private static int[] cycles; //represents cycle number it is in
    private static HashMap<Integer, Integer> size; //cycle num to size map

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            edges[a].add(b);
            edges[b].add(a);
        }
        st = new StringTokenizer(r.readLine());
        int s = Integer.parseInt(st.nextToken());

        if (isTree()) {
            boolean[] visited = new boolean[n];
            boolean[] hit = new boolean[n];
            for (int cases = 0; cases < s; cases++) {
                int query = 0;
                while (true) {
                    int dist = 1;
                    visited[query] = true;
                    hit[query] = true;
                    System.out.println(query + 1);
                    System.out.flush();
                    st = new StringTokenizer(r.readLine());
                    int response = Integer.parseInt(st.nextToken()) - 1;
                    if (response == query) {
                        break;
                    } else if (hit[response]) {
                        int prior = query;
                        dist = dist / 2;
                        for (int i = 0; i < dist; i++) {
                            if (edges[response].get(0) != prior) {
                                prior = response;
                                response = edges[response].get(1);
                            } else {
                                prior = response;
                                response = edges[response].get(0);
                            }
                        }
                    } else {
                        int prior = query;
                        dist = 1;
                        while (edges[response].size() == 2) {
                            if (edges[response].get(0) != prior) {
                                if (visited[edges[response].get(0)])
                                    break;
                                prior = response;
                                response = edges[response].get(0);
                                dist++;
                            } else {
                                if (visited[edges[response].get(1)])
                                    break;
                                prior = response;
                                response = edges[response].get(1);
                                dist++;
                            }
                            hit[response] = true;
                        }
                        query = response;

                    }
                }
            }
        } else {
            for (int cases = 0; cases < s; cases++) {
                cyclic();
            }
        }

    }

//    private static void dfs() {
//        for (int i = 0)
//    }

    private static boolean isTree() {
        boolean[] visited = new boolean[n];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        LinkedList<Integer> prior = new LinkedList<Integer>();
        stack.add(0);
        prior.add(-1);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int priorVal = prior.pop();
//            System.out.println(top + " " + priorVal);
            for (int i = 0; i < edges[top].size(); i++) {
                if (visited[edges[top].get(i)] && edges[top].get(i) != priorVal) {
                    return false;
                } else if (edges[top].get(i) != priorVal) {
                    stack.addFirst(edges[top].get(i));
                    prior.addFirst(top);
                    visited[edges[top].get(i)] = true;
                }

            }
        }
        return true;
    }

    private static void cyclic() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int curSize = n;
        int query = 0;
        while (true) {
            System.out.println(query + 1);
            System.out.flush();
            StringTokenizer st = new StringTokenizer(r.readLine());
            int response = Integer.parseInt(st.nextToken()) - 1;
            if (response == query) {
                break;
            } else {
                curSize /= 2;
                int priorNode = query;
                int curNode = response;
                for (int q = 0; q < curSize - 1; q++) {
//                        System.out.println("CURRENT " + curNode);
                    if (edges[curNode].get(0) != priorNode) {
                        priorNode = curNode;
                        curNode = edges[curNode].get(0);
                    } else {
                        priorNode = curNode;
                        curNode = edges[curNode].get(1);
                    }
                }
                query = curNode;
            }
        }
        return;
    }

}

