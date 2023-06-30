package com.nickgonzalez.trainhsr.helper;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;

import java.util.ArrayList;
import java.util.List;

public class Pathfinder {
    public List<Station> findStationsFromOriginToDestination(Station origin, Station destination) {
        List<Station> open = new ArrayList<Station>();
        List<Station> closed = new ArrayList<Station>();

        open.add(origin);
        while(open.isEmpty() == false) {
            Station currentStation = open.get(0);
            int currentIndex = 0;
            for(int i = 0; i < open.size(); i++) {
                if (open.get(i).getF() < currentStation.getF()) {
                    currentStation = open.get(i);
                    currentIndex = i;
                }
            }
            open.remove(currentIndex);
            closed.add(currentStation);
            if(currentStation == destination) {
                List<Station> path = new ArrayList<>();
                Station current = currentStation;
                while(current != null) {
                    System.out.println(current.getCity());
                    path.add(current);
                    current = current.getParent();
                }
                return path;
            }
            List<Station> children = new ArrayList<>();
            List<Route> routes = currentStation.getOutbound();
            for(int i = 0; i < routes.size(); i++) {
                Station tempStation = routes.get(i).getDestination();
                if(closed.contains(tempStation)) {
                    continue;
                }
                children.add(tempStation);
            }
            for(int i = 0; i < children.size(); i++) {
                Station child = children.get(i);

                for(int j = 0; j < closed.size(); j++) {
                    if(child == closed.get(j)) {
                        continue;
                    }
                }
                double distanceBetweenCurrentAndChild = computeCost(currentStation, child);
                child.setG(currentStation.getG() + distanceBetweenCurrentAndChild);
                double distanceBetweenChildAndDestination = computeCost(child, destination);
                child.setH(distanceBetweenChildAndDestination);
                child.setF(child.getG() + child.getH());
                for(int j = 0; j < open.size(); j++) {
                    if(child == open.get(j) && child.getG() > open.get(i).getG()) {
                        continue;
                    }
                }
                child.setParent(currentStation);
                open.add(child);
            }
        }
        return null;
    }

    public double computeCost(Station from, Station to) {
        double R = 6372.8; // Earth's Radius, in kilometers

        double dLat = Math.toRadians(to.getLatitude() - from.getLatitude());
        double dLon = Math.toRadians(to.getLongitude() - from.getLongitude());
        double lat1 = Math.toRadians(from.getLatitude());
        double lat2 = Math.toRadians(to.getLatitude());

        double a = Math.pow(Math.sin(dLat / 2),2)
                + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
}
