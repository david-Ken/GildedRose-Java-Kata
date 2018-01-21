package com.gildedrose;



class GildedRose {
        private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	
	Item[] items;
 
	public GildedRose(Item[] items) {
        this.items = items;
    }

	public static void increaseQualityIfNotMax(Item item){
		if(item.quality < 50)
			item.updateQuality(1);
	}
	public static void decreaseQualityIfNotMin(Item item){
		if(item.quality > 0)
			item.updateQuality(-1);
	}
    public static void updateItem(Item item){
    	
    	
    	switch (item.name) {		
			case AGED_BRIE: increaseQualityIfNotMax(item);break;
			case BACKSTAGE : increaseQualityIfNotMax(item);
							 if(item.sellIn < 11) increaseQualityIfNotMax(item);
							 if(item.sellIn < 6 ) increaseQualityIfNotMax(item);
							 break;
			case SULFURAS : ;break;
			default : decreaseQualityIfNotMin(item);break;
		}
      
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
        
        if(item.sellIn < 0){
        	switch (item.name) {
			case AGED_BRIE: increaseQualityIfNotMax(item);break;
			case BACKSTAGE : item.quality = 0;break;
			case SULFURAS : ;break;
			default : decreaseQualityIfNotMin(item);break;
			}     	
        	
        }

       
        
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	updateItem(items[i]);
    }
    }
}
