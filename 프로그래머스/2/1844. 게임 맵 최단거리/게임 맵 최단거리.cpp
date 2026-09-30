#include <vector>
#include <iostream>
#include <deque>
using namespace std;

struct Point {
    int x, y, dist;
};

int solution(vector<vector<int> > maps)
{
    int n = maps.size();
    int m = maps[0].size();
    vector<vector<bool>> visited(n, vector<bool>(m, false)) ;
    deque<Point> q ;
    q.push_back(Point{0, 0, 0});
    
    vector<int> dx = {0, 1, 0, -1};
    vector<int> dy = {1, 0, -1, 0};
    
    while (q.size() != 0){
        int x = q.front().x;
        int y = q.front().y;
        int dist = q.front().dist;
        
        q.pop_front();
        
        if ( x == n - 1 && y == m - 1){
            return dist + 1;
        }
        
        for (int i = 0; i < 4; i ++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if ( (0 <= nx && nx < n) && (0 <= ny && ny < m) ) {
                if (!visited[nx][ny] && maps[nx][ny] == 1){
                    q.push_back(Point{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    return -1;
}