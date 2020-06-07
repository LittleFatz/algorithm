package com.littlefatz;

import java.util.*;

//https://leetcode-cn.com/problems/word-ladder-ii/description/
public class WordLadderII {

    private Set<String> allWords;
    private Map<String, Set<String>> successors = new HashMap<>();
    private List<List<String>> results = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {


        allWords = new HashSet<>(wordList);
        if (!allWords.contains(endWord)) {
            return results;
        }

        boolean found = twoEndBFS(beginWord, endWord);
        if (!found) {
            return results;
        }

        LinkedList<String> path = new LinkedList<>();
        path.add(beginWord);
        tranformToResults(beginWord, endWord, path);

        return results;
    }

    private boolean twoEndBFS(String beginWord, String endWord) {

        boolean found = false;
        boolean forward = true;
        int length = beginWord.length();

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        while(!beginVisited.isEmpty() && !endVisited.isEmpty()) {

             if (beginVisited.size() > endVisited.size()) {
                 Set<String> temp = beginVisited;
                 beginVisited = endVisited;
                 endVisited = temp;
                 forward = !forward;
             }

             Set<String> nextLevelVisited = new HashSet<>();
             for (String word : beginVisited) {
                 char[] wordArray = word.toCharArray();
                 for (int i = 0; i < length; i++) {
                     char origin = wordArray[i];
                     for (char c = 'a'; c <= 'z'; c++) {
                         if (c == origin) {
                             continue;
                         }

                         wordArray[i] = c;
                         String newWord = new String(wordArray);

                         if (allWords.contains(newWord)) {
                             if (endVisited.contains(newWord)) {
                                 found = true;
                                 addSuccessors(word, newWord, forward);
                             }

                             if (!visited.contains(newWord)) {
                                 //注意：这里不能直接添加newWord到visited
                                 //因为下一个单词的变换单词，有可能以前曾经出现过的相同，而这种单词也应该添加到successors
//                                 visited.add(newWord);
                                 nextLevelVisited.add(newWord);
                                 addSuccessors(word, newWord, forward);
                             }

                         }
                     }

                     wordArray[i] = origin;
                 }
             }

             visited.addAll(nextLevelVisited);
             beginVisited = nextLevelVisited;
             if (found) {
                 break;
             }
        }

        return found;

    }

    private void addSuccessors(String currentWord, String nextWord, boolean forward) {

        if (!forward) {
            String temp = currentWord;
            currentWord = nextWord;
            nextWord = temp;
        }

        Set<String> successorSet = successors.computeIfAbsent(currentWord, k -> new HashSet<String>());
        successorSet.add(nextWord);
    }


    private void tranformToResults(String beginWord, String endWord, LinkedList<String> path) {
        if (beginWord.equals(endWord)) {
            results.add(new ArrayList<>(path));
            return;
        }

        if (!successors.containsKey(beginWord)) {
            return;
        } else {
            for (String successor : successors.get(beginWord)) {
                path.add(successor);
                tranformToResults(successor, endWord, path);
                path.removeLast();
            }
        }


    }



    public static void main(String[] args) {
//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");

        List<String> wordList = new ArrayList<>(Arrays.asList("flail","halon","lexus","joint","pears","slabs","lorie","lapse","wroth","yalow","swear","cavil","piety","yogis","dhaka","laxer","tatum","provo","truss","tends","deana","dried","hutch","basho","flyby","miler","fries","floes","lingo","wider","scary","marks","perry","igloo","melts","lanny","satan","foamy","perks","denim","plugs","cloak","cyril","women","issue","rocky","marry","trash","merry","topic","hicks","dicky","prado","casio","lapel","diane","serer","paige","parry","elope","balds","dated","copra","earth","marty","slake","balms","daryl","loves","civet","sweat","daley","touch","maria","dacca","muggy","chore","felix","ogled","acids","terse","cults","darla","snubs","boats","recta","cohan","purse","joist","grosz","sheri","steam","manic","luisa","gluts","spits","boxer","abner","cooke","scowl","kenya","hasps","roger","edwin","black","terns","folks","demur","dingo","party","brian","numbs","forgo","gunny","waled","bucks","titan","ruffs","pizza","ravel","poole","suits","stoic","segre","white","lemur","belts","scums","parks","gusts","ozark","umped","heard","lorna","emile","orbit","onset","cruet","amiss","fumed","gelds","italy","rakes","loxed","kilts","mania","tombs","gaped","merge","molar","smith","tangs","misty","wefts","yawns","smile","scuff","width","paris","coded","sodom","shits","benny","pudgy","mayer","peary","curve","tulsa","ramos","thick","dogie","gourd","strop","ahmad","clove","tract","calyx","maris","wants","lipid","pearl","maybe","banjo","south","blend","diana","lanai","waged","shari","magic","duchy","decca","wried","maine","nutty","turns","satyr","holds","finks","twits","peaks","teems","peace","melon","czars","robby","tabby","shove","minty","marta","dregs","lacks","casts","aruba","stall","nurse","jewry","knuth"));


        WordLadderII solution = new WordLadderII();
        String beginWord = "magic";
        String endWord = "pearl";
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }




}
