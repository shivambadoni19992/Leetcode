func groupAnagrams(strs []string) [][]string {

    anagramMap := make(map[string][]string)

    result := [][]string{}

    for _, word := range strs {
        sortedRune := []rune(word)
        slices.Sort(sortedRune)

        sortedWord := string(sortedRune)
        anagramMap[sortedWord] = append(anagramMap[sortedWord], word);
    }

    for _, group := range anagramMap {
        words := []string{}
        for _, word := range group {
            words = append(words, word)
        }
        result = append(result, words)
    }
    return result

    
    
}