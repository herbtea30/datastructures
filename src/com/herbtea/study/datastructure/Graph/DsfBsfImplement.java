package com.herbtea.study.datastructure.Graph;

import com.herbtea.study.datastructure.Queue.Queue;

import java.util.LinkedList;
import java.util.Stack;

public class DsfBsfImplement {
    static class Graph {
        class Node{
            int data;
            LinkedList<Node> adjacent;
            boolean marked;
            Node (int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<Node>();
            }
        }
        Node[] nodes;
        Graph(int size){
            nodes = new Node[size];
            for(int i = 0; i < size; i++){
                nodes[i] = new Node(i);
            }
        }
        void addEdge(int i1, int i2){
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if(!n1.adjacent.contains(n2)){
                n1.adjacent.addLast(n2);
            }
            if(!n2.adjacent.contains(n1)){
                n2.adjacent.addLast(n1);
            }
        }
        void dfs() {
            dfs(0);
        }
        void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);
            root.marked = true;
            //stack에 노드가 없읋때까지 반복작업 수행
            while(!stack.isEmpty()){
                Node r = stack.pop();
                for(Node n : r.adjacent) {
                    if(n.marked == false){
                        n.marked = true;
                        stack.push(n);
                    }
                }
                visit(r);
            }
        }
        void bfs() {
            bfs(0);
        }
        void bfs(int index){
            Node root = nodes[index];
            Queue<Node> queue = new Queue<Node>();
            queue.enqueue(root);
            root.marked = true;
            //queue가 비어있을때까지 반복작업
            while(!queue.isEmpty()){
                Node r = queue.dequeue();
                for(Node n : r.adjacent){
                    if(n.marked == false){
                        n.marked = true;
                        queue.enqueue(n);
                    }
                }
                visit(r);
            }
        }
        //인접리스트는 노드의 주소를 가지고 있기 때문에, 노드를 받는 형태로 되어야함.
        void dfsR(Node r){
            if(r == null) return;
            r.marked = true;
            visit(r);
            for(Node n: r.adjacent){
                if(n.marked == false) {
                    dfsR(n);
                }
            }
        }
        void dfsR(int index) {
            Node r = nodes[index];
            dfsR(r);
        }
        void dfsR() {
            dfsR(0);
        }

        void visit(Node n) {
            System.out.print(n.data + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        g.dfsR(3);

    }
}