/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Agu
 */
import java.util.*;

public class Graph {
    ArrayList<ArrayList<Integer>> adjacencyList;        // adjcency list
    int vertices;                                       // number of vertices
    
    Graph(int vertCount) {                              // constructor that build the adjacncy list
        adjacencyList = new ArrayList<ArrayList<Integer>>(vertCount);
        vertices = vertCount;
        for (int i = 0; i < vertices; i++) {            // fills the list with lists
            adjacencyList.add(new ArrayList<Integer>());
        }
    }
    
    void addEdge(int x, int y) {                        // adds edges to specified list x
        adjacencyList.get(x).add(y);
    }
    
    void helper(int a, boolean visitedNodes[], Stack<Integer> s) {  // sort helper method that recursivly checks vertices
        visitedNodes[a] = true;                         // sets the current node to visited

        for (int i = 0; i < adjacencyList.get(a).size(); i++) { //checks all the vertices adjacent to this vertec
            if (visitedNodes[adjacencyList.get(a).get(i)] == false) {
                helper(adjacencyList.get(a).get(i), visitedNodes, s);
            }
        }
        s.push(new Integer(a));                         // pushes current vertex to the stack
    }
    
    void sort() {                                       // main topological sort method
        boolean visitedNodes[] = new boolean[vertices];
        Stack<Integer> s = new Stack<Integer>();        // initalizes the stack
        Arrays.fill(visitedNodes, false);               // sets all the visited nodes to false
        
        for (int i = 0; i < vertices; i++) {            // calls the help function to store the topological sort from each vertex
            if (visitedNodes[i] == false) {
                helper(i, visitedNodes, s);
            }
        }
        
        while (s.empty() == false){                     // print the sorted outcome
            int print = s.pop();
            System.out.print(print + " ");
        }
    }
}
