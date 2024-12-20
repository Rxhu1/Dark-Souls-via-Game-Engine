package org.uob.a2.gameobjects;

public class Equipment extends GameObject implements Usable {
    protected UseInformation useInformation;

    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation){
        super(id, name, description, hidden);
        this.useInformation = useInformation;
    }

        public void setUseInformation(UseInformation useInformation){
            this.useInformation = useInformation;
        }

        public UseInformation getUseInformation(){
            return this.useInformation;
        }

        public String use(GameObject target, GameState gamestate){

            String id = this.useInformation.getResult();
            if (gamestate.getMap().getCurrentRoom().getItem(id) != null){
                gamestate.getMap().getCurrentRoom().getItem(id).setHidden(false);
            }
            if (gamestate.getMap().getCurrentRoom().getExit(id) != null){
                gamestate.getMap().getCurrentRoom().getExit(id).setHidden(false);
            }
            if (gamestate.getMap().getCurrentRoom().getEquipment(id) != null){
                gamestate.getMap().getCurrentRoom().getEquipment(id).setHidden(false);
            }
            if (gamestate.getPlayer().hasEquipment("emerald")){
                if (target.getName().equals("emerald")){
                    gamestate.getPlayer().addScore(50);
                }
            }

            this.useInformation.setUsed(true);
            return this.useInformation.getMessage();

            
            //this.useInformation.setTarget(target.getName());
            /*Player p = gamestate.getPlayer();
            String use = "";
            for(Item i: p.getInventory()){
                switch (target.getName()){
                    case "chest":
                        if (i.getName() == "rusty key"){
                            //use key on chest
                            use = "You use the rusty key to open the chest. There appears to be something sharp inside...";
                        }
                        break;
                    case "drake":
                        if (i.getName() == "dagger"){
                            //kill drake with dagger
                            use = "You use the dagger to kill the drake. A shiny object falls to the floor...";
                        }
                        break;
                    case "lava":
                        if (i.getName() == "lava ring"){
                            //walk on lava to get item using lava ring
                            use = "You use the lava ring to be invincible to lava. There seems to be an item in the middle of a pool of lava...";
                        }
                        break;
                    }
            }*/
        }

    /**
     * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
     * and the associated use information.
     *
     * @return a string describing the equipment
     */
    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }
}
