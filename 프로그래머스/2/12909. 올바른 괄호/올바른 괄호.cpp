#include <string>
#include <iostream>
#include <vector>

using namespace std;

bool solution(string s)
{
    bool answer = true;

    string stack = "";
    
    for (char c : s){
     
        if ( c == '(') {
            stack += c;
        } else {
            if (stack[stack.size() - 1] == '('){
                stack.pop_back();
            } else {
                return false;
            }
        }
        
    }
    
    if (stack.size() == 0) {
        return true;
    } else {
        return false;
    }
    return true;
}