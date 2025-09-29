func isAnagram(s string, t string) bool {
    var count [26]int;


    if len(s) != len(t) {
        return false;
    }
    for _, ch := range s {
        count[ch - 'a']++;
    }
    for _, ch := range t {
        count[ch - 'a']--;
        if count[ch - 'a'] < 0 {
            return false;
        }
    }
    return true;
}