package com.ajira;

import java.util.*;

public class PlatoonApllication {

    public static void main(String[] args) {
        /* We can change the input based on command argments*/
        /* For Testing hard coded the input values */

        String ownPlatoonsInput = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
        String opponentPlatoonsInput = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
        Map<String, Integer> ownArmyPlatoonsMap = PlatoonUtility.getOurArmyPlatoonsMap(ownPlatoonsInput);
        List<Platoon> listOwnPlatoons = PlatoonUtility.getProblityWining(ownPlatoonsInput);
        List<Platoon> listOppPlatoons = PlatoonUtility.getProblityWining(opponentPlatoonsInput);
        List<Platoon> findMatchingPlatoon = MatchingPlatoon.findMatchingPlatoon(listOwnPlatoons, listOppPlatoons, ownArmyPlatoonsMap);
        String output = "";
        int count = 0;
        for (Platoon finalResult : findMatchingPlatoon) {
            if (finalResult.getResult() != null) {
                output = output + finalResult.getResult();
                count++;
            } else {
                String penidngPlatoon = ownArmyPlatoonsMap.keySet().stream().limit(1).findFirst().get();
                output = output + penidngPlatoon + "#" + ownArmyPlatoonsMap.get(penidngPlatoon) + ";";
                if (ownArmyPlatoonsMap.get(penidngPlatoon) > finalResult.getSoldierCount()) {
                    count++;
                }
                ownArmyPlatoonsMap.remove(penidngPlatoon);
            }
        }
        System.out.println(output);
        if (count < 3) {
            System.out.println("There is no chance of winning");
        }

    }


}

