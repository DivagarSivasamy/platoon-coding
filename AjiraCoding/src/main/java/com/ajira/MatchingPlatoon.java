package com.ajira;

import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public class MatchingPlatoon {


    public List<Platoon> findMatchingPlatoon(List<Platoon> armyPlatoonList,
                                             List<Platoon> opponenetArmyPlatoonsList, Map<String, Integer> ownArmyPlatoonsMap) {
        armyPlatoonList.forEach(own -> {
            for (Platoon opp : opponenetArmyPlatoonsList) {
                if (PlatoonUtility.getAdvantage().get(own.getSoldierClass()).contains(opp.getSoldierClass()) && opp.getResult() == null) {
                    if ((own.getSoldierCount() * 2) > opp.getSoldierCount()) {
                        opp.setResult(own.getSoldierClass() + "#" + own.getSoldierCount() + ";");
                        ownArmyPlatoonsMap.remove(own.getSoldierClass());
                        break;
                    }
                }
            }
        });
        return opponenetArmyPlatoonsList;
    }
}
