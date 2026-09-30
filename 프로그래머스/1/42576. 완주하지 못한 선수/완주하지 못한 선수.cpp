#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    
    map<string, int> m ;
    
    for (string p : participant){
        m[p] ++ ;
    }
    
    for (string c : completion){
        m[c] -- ;
    }
    
    vector<string> result ;
    
    for (auto [key, value] : m) {
        if (value != 0){
            result.push_back(key);
        }
    }
    
    return result[0];
    
}