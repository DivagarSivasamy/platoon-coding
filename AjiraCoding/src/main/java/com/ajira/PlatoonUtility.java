package com.ajira;


import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public final class PlatoonUtility {

    private static final String seperator = ";";
    private static final String regexSeperator = "#";

    public Map<String, Integer> getOurArmyPlatoonsMap(String armyPlatoons) {
        String[] armyPlatoonsList = armyPlatoons.split(seperator);
        Map<String, Integer> armyPlatoonsMap = new HashMap<String, Integer>();
        for (int i = 0; i < armyPlatoonsList.length; i++) {
            String soldierCount = armyPlatoonsList[i].split(regexSeperator)[1];
            String platoonsType = armyPlatoonsList[i].split(regexSeperator)[0];
            armyPlatoonsMap.put(platoonsType, Integer.valueOf(soldierCount));
        }
        return armyPlatoonsMap;
    }

    public List<Platoon> getProblityWining(String armyClassesPlatoon) {
        String[] armyOwnPlatoons = armyClassesPlatoon.split(seperator);
        List<Platoon> armyPlatoonList = new ArrayList<Platoon>();
        armyList(armyOwnPlatoons, armyPlatoonList);
        return armyPlatoonList;
    }

    private void armyList(String[] armyPlatoons, List<Platoon> armyPlatoonList) {
        for (int i = 0; i < armyPlatoons.length; i++) {
            String solider = armyPlatoons[i].split(regexSeperator)[0];
            int count = Integer.valueOf(armyPlatoons[i].split(regexSeperator)[1]);
            Platoon p = new Platoon();
            p.setSoldierClass(solider);
            p.setSoldierCount(count);
            armyPlatoonList.add(p);

        }
    }

    public Map<String, String> getAdvantage() {
        Map<String, String> advMap = new HashMap<>();
        advMap.put("Militia", "Spearmen,LightCavalry");
        advMap.put("Spearmen", "LightCavalry,HeavyCavalry");
        advMap.put("LightCavalry", "FootArcher,CavalryArcher");
        advMap.put("HeavyCavalry", "Militia,FootArcher,LightCavalry");
        advMap.put("CavalryArcher", "Spearmen,HeavyCavalry");
        advMap.put("FootArcher", "Militia,CavalryArcher");
        return advMap;
    }


}
