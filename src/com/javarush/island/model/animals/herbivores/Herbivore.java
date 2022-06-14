package com.javarush.island.model.animals.herbivores;

import com.javarush.island.model.common.BasicItem;
import com.javarush.island.model.common.GameField;
import com.javarush.island.model.settings.Settings;
import com.javarush.island.model.plants.Plant;
import lombok.EqualsAndHashCode;
import com.javarush.island.model.animals.Animal;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode
public class Herbivore extends Animal {

    @Override
    public void eat() {

        Settings settings = GameField.getInstance().getSettings();
        double saturation = this.getCurrentSaturation();

        if (saturation != 0) {
            double newSaturation = saturation - this.getFullSaturation() / settings.getMaxNumberOfDaysWithoutEating();
            if (newSaturation < 0.001)
                newSaturation = 0;
            this.setCurrentSaturation(newSaturation);
        }

        List<BasicItem> itemsOnPosition = this.getPosition().getItemsOnPosition();
        List<BasicItem> plantsOnPosition = itemsOnPosition.stream()
                .filter(el -> el.getClass().getSuperclass().equals(Plant.class))
                .toList();

        if (plantsOnPosition.isEmpty())
            return;

        int plantIndex = ThreadLocalRandom.current().nextInt(plantsOnPosition.size());
        Plant plantToEat = (Plant) plantsOnPosition.get(plantIndex);

        itemsOnPosition.remove(plantToEat);

        if (plantToEat.getWeight() > (this.getFullSaturation() - this.getCurrentSaturation())) {
            this.setCurrentSaturation(this.getFullSaturation());
        } else {
            this.setCurrentSaturation(this.getFullSaturation() - this.getCurrentSaturation() + plantToEat.getWeight());
        }

    }

}
