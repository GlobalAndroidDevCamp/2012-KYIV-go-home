package org.away.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.away.controller.GeoCodingService.GeoCoordinates;
import org.away.controller.SuperAI;
import org.away.dao.impl.LocalDao;
import org.away.model.Itinary;
import org.away.model.Station;
import org.away.model.Transport;

public class FirstStopAI implements SuperAI {
	
	
//	private List<> findNearStops(GeoCoordinates point) {
//		return findNearStops(point, 500);
//	}
//	
//    private List<> findNearStops(GeoCoordinates _arg2, int _arg3):Array{
//        List<Route> res = new ArrayList<Route>();
//        var _local5:int;
//        while (_local5 < _arg1.q.slat.length) {
//            if (_arg2.distanceFrom(new LatLng(_arg1.q.slat[_local5], _arg1.q.slng[_local5])) < _arg3){
//                _local4.push(_local5);
//            };
//            _local5++;
//        };
//        return (_local4);
//    }

	
    private List<Itinary> findDirects(GeoCoordinates start, GeoCoordinates end) {
    	List<Station> stations = new LocalDao().fetchRoutes();

    	Station approximateStart = new Station(start.getLattitude(), start.getLongtitude(), "", 0, null, 0, null);
    	Station closestStart = StationUtils.findClosest(stations, approximateStart);
    	
    	Station approximateEnd = new Station(end.getLattitude(), end.getLongtitude(), "", 0, null, 0, null);
    	Station closestEnd = StationUtils.findClosest(stations, approximateEnd);
    	
    	int[] startIds = closestStart.getSlines();
    	int[] endIds = closestEnd.getSlines();
    	
    	int[] similar = StationUtils.findSimilar(startIds, endIds);
    	
    	List<Itinary> itinaries = new ArrayList<Itinary>();
    	for (int i = 0; i < similar.length; i++) {
			Itinary iti = new Itinary(2.0, 60*35, List<Transport>)null, (List<Station>)null);
		}
    	
//        int sLineI;
//        int numberOfSLines;
//        int finishStopsArrayLength;
//        Array startStopsArray = findNearStops(mapDrawer, startLatLon);
//        Array finishStopsArray = findNearStops(mapDrawer, endLatLon);
//        Array sLinesArrayResult = [];
//        Array startStopsArrayResult = [];
//        Array fisishStopsArrayResult = [];
//        int startStopsArrayLength = (startStopsArray.length - 1);
//        while (startStopsArrayLength > -1) {
//            numberOfSLines = (mapDrawer.q.slines[startStopsArray[startStopsArrayLength]].length - 1);
//            while (numberOfSLines > -1) {
//                sLineI = mapDrawer.q.slines[startStopsArray[startStopsArrayLength]][numberOfSLines];
//                finishStopsArrayLength = (finishStopsArray.length - 1);
//                while (finishStopsArrayLength > -1) {
//                    if (CanGo(mapDrawer, sLineI, startStopsArray[startStopsArrayLength], finishStopsArray[finishStopsArrayLength])){
//                        sLineFromResult = sLinesArrayResult.indexOf(sLineI);
//                        if (sLineFromResult < 0){
//                            sLinesArrayResult.push(sLineI);
//                            startStopsArrayResult.push(startStopsArray[startStopsArrayLength]);
//                            fisishStopsArrayResult.push(finishStopsArray[finishStopsArrayLength]);
//                        } else {
//                            if (GetDistance(mapDrawer, startLatLon, startStopsArrayResult[sLineFromResult]) > GetDistance(mapDrawer, startLatLon, startStopsArray[startStopsArrayLength])){
//                                startStopsArrayResult[sLineFromResult] = startStopsArray[startStopsArrayLength];
//                            };
//                            if (GetDistance(mapDrawer, endLatLon, fisishStopsArrayResult[sLineFromResult]) > GetDistance(mapDrawer, endLatLon, finishStopsArray[finishStopsArrayLength])){
//                                fisishStopsArrayResult[sLineFromResult] = finishStopsArray[finishStopsArrayLength];
//                            };
//                        };
//                    };
//                    finishStopsArrayLength--;
//                };
//                numberOfSLines--;
//            };
//            startStopsArrayLength--;
//        };
//        sLineFromResult = (startStopsArrayResult.length - 1);
//        while (sLineFromResult > -1) {
//            startStopsArrayResult[sLineFromResult] = mapDrawer.q.lstops[sLinesArrayResult[sLineFromResult]].indexOf(startStopsArrayResult[sLineFromResult]);
//            fisishStopsArrayResult[sLineFromResult] = mapDrawer.q.lstops[sLinesArrayResult[sLineFromResult]].lastIndexOf(fisishStopsArrayResult[sLineFromResult]);
//            sLineFromResult--;
//        };
//        return ([sLinesArrayResult, startStopsArrayResult, fisishStopsArrayResult]);
    	throw (List<Station>) new UnsupportedOperationException("no cool ai now");
    }



	@Override
	public List<Itinary> bringMeHome(GeoCoordinates start, GeoCoordinates end) {
		return findDirects(start, end);
	}
}