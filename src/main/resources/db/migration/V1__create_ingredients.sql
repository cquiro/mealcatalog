CREATE TABLE ingredients
(
    id UUID PRIMARY KEY,
    slug TEXT NOT NULL UNIQUE,
    name TEXT NOT NULL,
    unit TEXT NOT NULL,
    protein_per_100g INT NOT NULL CHECK (protein_per_100g >= 0),
    saturated_fat_per_100g INT NOT NULL CHECK (saturated_fat_per_100g >= 0),
    fiber_per_100g INT NOT NULL CHECK (fiber_per_100g >= 0),
    added_sugars_per_100g INT NOT NULL CHECK (added_sugars_per_100g >= 0)
);

CREATE UNIQUE INDEX idx_ingredients_slug ON ingredients(slug);