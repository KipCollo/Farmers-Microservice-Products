-- Insert categories
INSERT INTO category (id, name, description) VALUES
                                                 (1, 'Vegetables', 'Fresh farm vegetables'),
                                                 (2, 'Fruits', 'Organic farm fruits'),
                                                 (3, 'Dairy', 'Dairy farm products'),
                                                 (4, 'Grains', 'Harvested grains and cereals'),
                                                 (5, 'Meat', 'Fresh farm meat and poultry');

-- Insert products
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES
                                                                                        (1, 'Tomatoes', 'Fresh red tomatoes', 100.0, 50.00, 1),
                                                                                        (2, 'Cabbages', 'Organic green cabbages', 80.0, 40.00, 1),
                                                                                        (3, 'Bananas', 'Sweet ripe bananas', 120.0, 30.00, 2),
                                                                                        (4, 'Mangoes', 'Juicy mangoes', 90.0, 60.00, 2),
                                                                                        (5, 'Milk', 'Fresh cow milk', 200.0, 100.00, 3),
                                                                                        (6, 'Yogurt', 'Strawberry flavored yogurt', 150.0, 120.00, 3),
                                                                                        (7, 'Maize', 'Dry maize grains', 300.0, 35.00, 4),
                                                                                        (8, 'Beans', 'Red kidney beans', 250.0, 70.00, 4),
                                                                                        (9, 'Chicken', 'Live farm chicken', 50.0, 500.00, 5),
                                                                                        (10, 'Beef', 'Fresh beef cuts', 60.0, 600.00, 5);