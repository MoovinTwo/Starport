package com.moovintwo.starport.Data;

import net.kyori.adventure.text.Component;

import java.util.HashMap;
import java.util.Map;

import static com.moovintwo.starport.Data.UUIDs.*;

public class Ranks {

    public static Map<String, Component> ranks = new HashMap<>();

    public static void init() {

        ranks.put(Moovintwo_UUID, RanksComponents.Owner);
        ranks.put(Alex_UUID, RanksComponents.CoOwner);
        ranks.put(ThreadedFlowey_UUID, RanksComponents.Developer);
        ranks.put(Deplo_UUID, RanksComponents.Admin);
        ranks.put(Karma_UUID, RanksComponents.Moderator);
        ranks.put("Other", RanksComponents.Member);

    }

    public static Component getRank(String uuid) {
        return ranks.get(uuid);
    }



}
