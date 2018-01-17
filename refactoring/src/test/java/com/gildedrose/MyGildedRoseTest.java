package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;



public class MyGildedRoseTest {

	@Test
	public void testGildedRose() {
		// fail("Not yet implemented");
	}

	@Test
	public void testUpdateQuality() {

		Item[] item = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
		GildedRose app = new GildedRose(item);
		app.updateQuality();

		/**** TEST SUR UN PRODUIT NORMALE ***********/

		// sellIn et qualité positif
		assertTrue("diminution normale",item[0].sellIn == 9 && item[0].quality == 19);
		/****
		 * pour tester si les deux valeur diminuent
		 ****/

		// sellIn positf qualité 0
		item[0].quality = 0;
		app.updateQuality();
		assertFalse("dimininution produit de qualité 0 ", item[0].quality < 0);
		/****
		 * pour tester que la qualité ne va pas en dessous de 0
		 ****/

		// sellIn négatif qualité positfi
		item[0].quality = 20;
		item[0].sellIn = -10;
		app.updateQuality();
		assertFalse("dimininution produit de qualité 0 ", item[0].quality < 0);
		/****
		 * pour tester que le qualité diminue même si le sellIn est déja négatif
		 ****/
		//sellIn et qualité négatif
		item[0].quality = -10;
		item[0].sellIn = -10;
		app.updateQuality();
		assertTrue("dimininution produit de qualité 0 ", item[0].quality == -10 && item[0].sellIn == -11);

		
		/******** TEST SUR DU SULFURAS ***************/
		item[0].name = "Sulfuras, Hand of Ragnaros";
		item[0].quality = 20;
		item[0].sellIn = 10;
		app.updateQuality();
		assertTrue("Sulfuras ", item[0].quality == 20 && item[0].sellIn == 10);

		item[0].name = "Sulfuras, Hand of Ragnaros";
		item[0].quality = 20;
		item[0].sellIn = -10;
		app.updateQuality();
		assertTrue("Sulfuras ", item[0].quality == 20 && item[0].sellIn == -10);
		/*** les valeurs du Sulfuras ne changent pas ***/

		/************** TEST SUR DU AGED BRIE **************/
		// sellIn < 6 qualite < 50
		item[0].name = "Aged Brie";
		item[0].quality = 20;
		item[0].sellIn = 3;
		app.updateQuality();
		assertTrue("Aged Brie mois 6 de sellIn", item[0].quality == 21 && item[0].sellIn == 2);

		// sellIn < 11 qualite < 50
		item[0].name = "Aged Brie";
		item[0].quality = 20;
		item[0].sellIn = 8;
		app.updateQuality();
		assertTrue("Aged Brie mois 6 de sellIn", item[0].quality == 21 && item[0].sellIn == 7);

		// sellIn > 11 qualite < 50
		item[0].name = "Aged Brie";
		item[0].quality = 20;
		item[0].sellIn = 15;
		app.updateQuality();
		assertTrue("Aged Brie mois 6 de sellIn", item[0].quality == 21 && item[0].sellIn == 14);

		// sellIn negatif qualite < 60
		item[0].name = "Aged Brie";
		item[0].quality = 20;
		item[0].sellIn = 0;
		app.updateQuality();
		assertTrue("Aged Brie mois 6 de sellIn", item[0].quality == 22 && item[0].sellIn == -1);

		// sellIn negatif qualite < 60
		item[0].name = "Aged Brie";
		item[0].quality = 20;
		item[0].sellIn = -10;
		app.updateQuality();
		assertTrue("Aged Brie mois 6 de sellIn", item[0].quality == 22 && item[0].sellIn == -11);
		
		// sellIn negatif qualite < 60
				item[0].name = "Aged Brie";
				item[0].quality = 60;
				item[0].sellIn = -10;
				app.updateQuality();
				assertTrue("Aged Brie mois 6 de sellIn", item[0].quality == 60 && item[0].sellIn == -11);

		/**************** TEST SUR DU BACKSATAGE *************/
		item[0].name = "Backstage passes to a TAFKAL80ETC concert";
		item[0].quality = 50;
		app.updateQuality();
		assertFalse("Qaualité égale à 50 ", item[0].quality > 50);

		// sellIn < 6 qualité < 50
		item[0].name = "Backstage passes to a TAFKAL80ETC concert";
		item[0].quality = 20;
		item[0].sellIn = 2;
		app.updateQuality();
		assertTrue("Backstage", item[0].quality == 23 && item[0].sellIn == 1);

		// sellIn < 11 qualite < 50
		item[0].name = "Backstage passes to a TAFKAL80ETC concert";
		item[0].quality = 20;
		item[0].sellIn = 8;
		app.updateQuality();
		assertTrue("Backstage  6 de sellIn", item[0].quality == 22 && item[0].sellIn == 7);

		// sellIn > 11 qualite < 60
		item[0].name = "Backstage passes to a TAFKAL80ETC concert";
		item[0].quality = 20;
		item[0].sellIn = 15;
		app.updateQuality();
		assertTrue("Backstage passes to a TAFKAL80ETC concert mois 6 de sellIn",
				item[0].quality == 21 && item[0].sellIn == 14);

		item[0].quality = 60;
		item[0].sellIn = 15;
		app.updateQuality();
		assertTrue("Backstage depansant 50 de qualité", item[0].quality== 60 && item[0].sellIn == 14);


		item[0].quality = 49;
		item[0].sellIn = 8;
		app.updateQuality();
		assertTrue("Backstage depansant 50 de qualité sellIn < 11", item[0].quality== 50 && item[0].sellIn == 7);

		item[0].quality = 49;
		item[0].sellIn = 3;
		app.updateQuality();
		assertTrue("Backstage depansant 50 de qualité sellIn < 11", item[0].quality== 50 && item[0].sellIn == 2);
		
		// sellIn == 0 qualite < 50
		item[0].name = "Backstage passes to a TAFKAL80ETC concert";
		item[0].quality = 20;
		item[0].sellIn = 0;
		app.updateQuality();
		assertTrue("Backstage passes to a TAFKAL80ETC concert mois 6 de sellIn",
				item[0].quality == 0 && item[0].sellIn == -1);

		// sellIn > 11 qualite < 60
		item[0].name = "Backstage passes to a TAFKAL80ETC concert";
		item[0].quality = 20;
		item[0].sellIn = -15;
		app.updateQuality();
		assertTrue("Backstage passes to a TAFKAL80ETC concert mois 6 de sellIn", item[0].quality == 0);

	}

	
}