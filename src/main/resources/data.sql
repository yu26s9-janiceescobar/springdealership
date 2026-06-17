-- Insert dealerships first (vehicles depend on them)
INSERT INTO dealership (name, address, phone_number) VALUES
                                                         ('NYC Auto Group', '123 Broadway, New York, NY', '212-555-0101'),
                                                         ('Brooklyn Motors', '456 Flatbush Ave, Brooklyn, NY', '718-555-0202'),
                                                         ('Queens Car Center', '789 Jamaica Ave, Queens, NY', '718-555-0303');

-- Insert vehicles (dealership_id references the dealerships above)
INSERT INTO vehicle (dealership_id, year, make, model, vehicle_type, color, odometer, price) VALUES
                                                                                                 (1, 2020, 'Toyota', 'Camry', 'Sedan', 'Black', 15000, 22000.00),
                                                                                                 (1, 2019, 'Honda', 'Civic', 'Sedan', 'White', 30000, 18000.00),
                                                                                                 (1, 2021, 'Ford', 'Explorer', 'SUV', 'Silver', 10000, 35000.00),
                                                                                                 (2, 2018, 'Chevrolet', 'Malibu', 'Sedan', 'Red', 45000, 15000.00),
                                                                                                 (2, 2022, 'Toyota', 'RAV4', 'SUV', 'Blue', 5000, 38000.00),
                                                                                                 (2, 2020, 'Nissan', 'Altima', 'Sedan', 'Gray', 22000, 19000.00),
                                                                                                 (3, 2021, 'Honda', 'CR-V', 'SUV', 'White', 12000, 32000.00),
                                                                                                 (3, 2019, 'Ford', 'Mustang', 'Coupe', 'Yellow', 18000, 28000.00),
                                                                                                 (3, 2023, 'Toyota', 'Corolla', 'Sedan', 'Black', 2000, 24000.00);