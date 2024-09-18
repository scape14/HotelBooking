-- Tabela de Usuários
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    phone VARCHAR(50),
    email VARCHAR(255) UNIQUE NOT NULL
);

-- Tabela de Categorias
CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_room VARCHAR(255) NOT NULL
);

-- Tabela de Recursos (Features)
CREATE TABLE features (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Tabela de Quartos (Rooms)
CREATE TABLE room (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_id BIGINT,
    number VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    available INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Tabela de Registro de Reservas (BookingJournal)
CREATE TABLE bookingjournal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    room_id BIGINT,
    date_from DATE NOT NULL,
    date_to DATE NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (room_id) REFERENCES room(id)
);


-- Inserir dados na tabela de Usuários
INSERT INTO user (first_name, last_name, phone, email) VALUES
('John', 'Doe', '123-456-7890', 'john.doe@example.com'),
('Jane', 'Smith', '098-765-4321', 'jane.smith@example.com');

-- Inserir dados na tabela de Categorias
INSERT INTO category (category_room) VALUES
('Single Room'),
('Double Room'),
('Suite');

-- Inserir dados na tabela de Recursos (Features)
INSERT INTO features (name, price) VALUES
('WiFi', 10.00),
('Breakfast', 20.00),
('Parking', 15.00);

-- Inserir dados na tabela de Quartos (Rooms)
INSERT INTO room (category_id, number, price, available) VALUES
(1, '101', 50.00, 10),
(2, '102', 75.00, 5),
(3, '201', 150.00, 2);

-- Inserir dados na tabela de Registro de Reservas (BookingJournal)
INSERT INTO bookingjournal (user_id, room_id, date_from, date_to, total_price) VALUES
(1, 1, '2024-09-01', '2024-09-05', 200.00),
(2, 2, '2024-09-10', '2024-09-15', 375.00);