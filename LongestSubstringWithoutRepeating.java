#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int lengthOfLongestSubstring(const string& s) {
    unordered_map<char, int> seen;
    int l = 0, max_len = 0;
    
    for (int r = 0; r < s.size(); ++r) {
        if (seen.find(s[r]) != seen.end() && seen[s[r]] >= l) {
            l = seen[s[r]] + 1;
        }
        seen[s[r]] = r;
        max_len = max(max_len, r - l + 1);
    }
    
    return max_len;
}

int main() {
    string s = "abcabcbb";
    cout << lengthOfLongestSubstring(s) << endl; // Output: 3
    return 0;
}