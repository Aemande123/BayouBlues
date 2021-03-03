package com.teamaurora.bayou_blues.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class BayouBluesConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Integer> bayouWeight;
        public final ForgeConfigSpec.ConfigValue<Integer> bayouHillsWeight;
        public final ForgeConfigSpec.ConfigValue<Integer> lilyBonemealBehavior;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Common configurations for Bayou Blues")
            .push("common");

            lilyBonemealBehavior = builder.comment("Lily bonemeal behavior. 0=none. 1=bonemealing lily pad grows lily flowers. 2=bonemealing lily flower gives you more of it.")
                    .define("Lily bonemeal behavior", 1);

            builder.comment("Values for biome frequencies; lower = more rare. (Requires restart)")
            .push("biome_weights");

            bayouWeight = builder.define("Bayou weight", 1);
            bayouHillsWeight = builder.define("Bayou Hills weight", 0);

            builder.pop();
            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
