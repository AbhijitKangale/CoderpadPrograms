package com.sapient.coderpad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class FindShortestPathInGivenTrainMap {

	static class Station {

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

		public List<Station> shortestPath(String from, String to) {

			// return null if both source and destination station are null
			if (from == null && to == null)
				return null;

			// this queue is to maintain station to be visited next
			Queue<Station> toVisit = new LinkedList<>();
			Map<Station, Station> parents = new HashMap<>();

			// add source station to queue so that we can start traversing tree from this
			// station
			toVisit.add(this.getStation(from));
			parents.put(this.getStation(from), null);

			while (!toVisit.isEmpty()) {
				Station station = toVisit.remove();

				if (station.equals(this.getStation(to)))
					break;

				for (Station adjStations : station.neighbours) {

					// to make sure visited vertex should not be visited again
					if (!parents.containsKey(adjStations)) {
						toVisit.add(adjStations);
						parents.put(adjStations, station);
					}
				}
			}

			// if there is no path from given source to destination then return null
			if (parents.get(this.getStation(to)) == null)
				return null;

			List<Station> shortestPathFromSourceToDestination = new LinkedList<>();
			Station current = this.getStation(to);
			while (current != null) {

				// add each vertex at head so that retrieval will be in reverse order
				shortestPathFromSourceToDestination.add(0, current);
				current = parents.get(current);
			}

			return shortestPathFromSourceToDestination;
		}

		private static String convertPathToStringRepresentation(List<Station> path) {
			if (path.isEmpty()) {
				return "";
			}
			return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
		}
	}

	public static boolean doTestsPass() {

		TrainMap trainMap = new TrainMap();

		trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street")
				.addStation("Moorgate").addStation("Farringdon").addStation("Barbican").addStation("Russel Square")
				.addStation("Holborn").addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

		trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
				.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
				.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
				.connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
				.connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
				.connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
				.connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
				.connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
				.connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
				.connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
				.connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
				.connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

		String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";

		return solution.equals(TrainMap
				.convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "St Paul's")));
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
}