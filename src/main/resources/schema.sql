CREATE TABLE public.Item (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(50) NOT NULL,
                             price INT NOT NULL,
                             stock_quantity INT NOT NULL
);

INSERT INTO public.Item(Id, name, price, stock_quantity)
values (1, 'mouse', 70, 40),
       (2, 'chocolate', 15, 100),
       (3, 'ssd hard drive', 120, 20);