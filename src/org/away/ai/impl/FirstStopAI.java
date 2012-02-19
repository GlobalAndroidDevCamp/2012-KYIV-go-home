package org.away.ai.impl;

import java.util.List;

import org.away.ai.SuperAI;
import org.away.controller.GeoCodingService.GeoCoordinates;
import org.away.model.Itinary;

public class FirstStopAI implements SuperAI {
    private List<Itinary> findDirects(GeoCoordinates start, GeoCoordinates end) {
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
    	throw new UnsupportedOperationException("no cool ai now");
    }

	@Override
	public List<Itinary> bringMeHome(GeoCoordinates start, GeoCoordinates end) {
		return findDirects(start, end);
	}
}