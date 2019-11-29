package com.sapient.coderpad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ConvertGivenTreeToGraphAndPrintGraph {

	private static class Station {

		private String name;

		private List<Station> neighbours;

		public Station(String name) {
			this.name = name;
			this.neighbours = new ArrayList<>(3);
		}

		String getName() {
			return name;
		}

		void addNeighbour(Station v) {
			this.neighbours.add(v);
		}

		List<Station> getNeighbours() {
			return this.neighbours;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof Station && this.name.equals(((Station) obj).getName());
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.name);
		}
	}

	private static class TrainMap {

		private HashMap<String, Station> stations;

		public TrainMap() {
			this.stations = new HashMap<>();
		}

		public TrainMap addStation(String name) {
			Station s = new Station(name);
			this.stations.putIfAbsent(name, s);
			return this;
		}

		public Station getStation(String name) {
			return this.stations.get(name);
		}

		public TrainMap connectStations(Station fromStation, Station toStation) {
			if (fromStation == null) {
				throw new IllegalArgumentException("From station is null");
			}
			if (toStation == null) {
				throw new IllegalArgumentException("From station is null");
			}
			fromStation.addNeighbour(toStation);
			toStation.addNeighbour(fromStation);
			return this;
		}
	}

	private static class Graph {

		HashMap<Object, LinkedList<Object>> adjList = new HashMap<>();

		HashMap<Object, Integer> indexes = new HashMap<>();

		int index = -1;

		public Graph(ArrayList<Object> vertices) {

			for (int i = 0; i < vertices.size(); i++) {
				Object vertex = vertices.get(i);
				LinkedList<Object> list = new LinkedList<>();
				adjList.put(vertex, list);
				indexes.put(vertex, ++index);
			}
		}

		public void addEdge(Object source, Object destination) {

			// add forward edge
			LinkedList<Object> list;
			list = adjList.get(source);
			list.addFirst(destination);
			adjList.put(source, list);
		}

		// Just to show how traversal happens in depth first search
		public void DFS() {

			int vertices = adjList.size();
			boolean[] visited = new boolean[vertices];

			for (Map.Entry<Object, LinkedList<Object>> entry : adjList.entrySet()) {
				Object source = entry.getKey();
				if (!visited[indexes.get(source)]) {
					DFSUtil(source, visited);
				}
			}
		}

		public void DFSUtil(Object source, boolean[] visited) {

			// mark this visited
			visited[indexes.get(source)] = true;

			System.out.print(source + " ");
			LinkedList<Object> list = adjList.get(source);
			for (int i = 0; i < list.size(); i++) {
				Object destination = list.get(i);
				if (!visited[indexes.get(destination)])
					DFSUtil(destination, visited);
			}
		}

		public void printGraph() {

			Set<Object> set = adjList.keySet();
			Iterator<Object> iterator = set.iterator();

			while (iterator.hasNext()) {
				Station vertex = (Station) iterator.next();
				System.out.print("Station " + vertex.getName() + " is connected to --> ");
				LinkedList<Station> list = (LinkedList<Station>) (Object) adjList.get(vertex);
				for (int i = 0; i < list.size(); i++) {
					System.out.print("\'" + list.get(i).getName() + "\'" + " ");
				}

				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		TrainMap trainMap = new TrainMap();

		trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street")
				.addStation("Moorgate").addStation("Farringdon").addStation("Barbican").addStation("Russel Square")
				.addStation("Holborn").addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

		ArrayList<Object> vertices = new ArrayList<>();

		vertices.add(trainMap.getStation("King's Cross St Pancras"));
		vertices.add(trainMap.getStation("Angel"));
		vertices.add(trainMap.getStation("Old Street"));
		vertices.add(trainMap.getStation("Moorgate"));
		vertices.add(trainMap.getStation("Farringdon"));
		vertices.add(trainMap.getStation("Barbican"));
		vertices.add(trainMap.getStation("Russel Square"));
		vertices.add(trainMap.getStation("Holborn"));
		vertices.add(trainMap.getStation("Chancery Lane"));
		vertices.add(trainMap.getStation("St Paul's"));
		vertices.add(trainMap.getStation("Bank"));

		Graph graph = new Graph(vertices);

		graph.addEdge(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"));
		graph.addEdge(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"));
		graph.addEdge(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"));
		graph.addEdge(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"));
		graph.addEdge(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"));
		graph.addEdge(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"));
		graph.addEdge(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"));
		graph.addEdge(trainMap.getStation("Angel"), trainMap.getStation("Old Street"));
		graph.addEdge(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"));
		graph.addEdge(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"));
		graph.addEdge(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"));
		graph.addEdge(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

		graph.printGraph();
	}
}
