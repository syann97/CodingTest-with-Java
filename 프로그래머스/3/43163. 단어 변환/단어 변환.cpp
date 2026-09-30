#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int min_value = 10000000;

bool diff_seconds(string word1, string word2) {
	int cnt = 0;

	for (int i = 0; i < word1.size(); i++) {
		if (word1[i] == word2[i]) continue;

		cnt += 1;
	}
	if (cnt == 1) {
		return true;
	}
	return false;
}

void dfs(vector<string> words, string now_word, string target_word, int depth, vector<bool> visited) {

	if (now_word == target_word) {
		min_value = min(depth, min_value);
	}

	for (int i = 0; i < words.size(); i++) {
		if (visited[i] == false) {
			if (diff_seconds(now_word, words[i])) {
				visited[i] = true;
				dfs(words, words[i], target_word, depth + 1, visited);
				visited[i] = false;
			}
		}
	}
}


int solution(string begin, string target, vector<string> words) {

	int n = words.size();

	vector<bool> visited(n, false);

	dfs(words, begin, target, 0, visited);
    
    if (min_value == 10000000){
        return 0;
    } else {
        return min_value;
    }

	return min_value;
}