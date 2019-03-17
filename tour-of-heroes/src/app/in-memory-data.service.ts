import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Hero } from './hero';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const heroes = [
      { id: 11, name: 'Apple Jack' },
      { id: 12, name: 'Pinky Pie' },
      { id: 13, name: 'Twlight Sparkles' },
      { id: 15, name: 'Spike' },
      { id: 16, name: 'Rainbow Dash' },
      { id: 17, name: 'Shutter Fly' },
      { id: 18, name: 'Discord'},
      { id: 19, name: 'Princess Luna' },
      { id: 20, name: 'Princess Celestia' }
    ];
    return {heroes};
  }

  // Overrides the genId method to ensure that a hero always has an id.
  // If the heroes array is empty,
  // the method below returns the initial number (11).
  // if the heroes array is not empty, the method below returns the highest
  // hero id + 1.
  genId(heroes: Hero[]): number {
    return heroes.length > 0 ? Math.max(...heroes.map(hero => hero.id)) + 1 : 11;
  }
}