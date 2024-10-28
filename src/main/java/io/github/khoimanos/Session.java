package io.github.khoimanos;

public class Session {
        private String chestflys;
        private String bench;
        private String tricepsPush;
        private String lateralRaises;

        public Session(String chestflys, String bench, String tricepsPush, String lateralRaises) {
            this.chestflys = chestflys;
            this.bench = bench;
            this.tricepsPush = tricepsPush;
            this.lateralRaises = lateralRaises;
        }

        // Getter-Methoden für die Eigenschaften
        public String getChestflys() { return chestflys; }
        public String getBench() { return bench; }
        public String getTricepsPush() { return tricepsPush; }
        public String getLateralRaises() { return lateralRaises; }
    }