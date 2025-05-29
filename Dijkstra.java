#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

// Dijkstra's algorithm to find shortest paths from start node
vector<int> dijkstra(int n, const vector<vector<int>>& edges, int start) {
    // Build adjacency list: graph[u] = {{v, w}, ...}
    vector<vector<pair<int, int>>> graph(n);
    for (const auto& edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        graph[u].push_back({v, w});
    }
    
    // Initialize distances
    vector<int> dist(n, INT_MAX);
    dist[start] = 0;
    
    // Min-heap: {distance, node}
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> heap;
    heap.push({0, start});
    
    while (!heap.empty()) {
        int d = heap.top().first;
        int u = heap.top().second;
        heap.pop();
        
        if (d > dist[u]) {
            continue;
        }
        
        for (const auto& [v, w] : graph[u]) {
            if (d + w < dist[v]) {
                dist[v] = d + w;
                heap.push({dist[v], v});
            }
        }
    }
    
    return dist;
}

int main() {
    int n = 4;
    vector<vector<int>> edges = {{0, 1, 4}, {0, 2, 1}, {2, 1, 2}, {1, 3, 1}, {2, 3, 5}};
    int start = 0;
    
    vector<int> dist = dijkstra(n, edges, start);
    
    // Print distances
    cout << "[";
    for (int i = 0; i < n; ++i) {
        if (dist[i] == INT_MAX) {
            cout << "inf";
        } else {
            cout << dist[i];
        }
        if (i < n - 1) cout << ", ";
    }
    cout << "]" << endl;
    
    return 0;
}