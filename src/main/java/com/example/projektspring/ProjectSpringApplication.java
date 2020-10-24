package com.example.projektspring;

import com.example.projektspring.service.BasketService;
import com.example.projektspring.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ProjectSpringApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ProjectSpringApplication.class, args);

        Scanner in = new Scanner(System.in);
		ProductService productService = ctx.getBean(ProductService.class);
		BasketService basketService = ctx.getBean(BasketService.class);

        do {
			System.out.println("wybierz opcje");
			System.out.println("1. wyswietl katalog produktow.");
			System.out.println("2. wyszukaj profukt po nazwie.");
			System.out.println("3. wyszukaj profukt po id.");
			System.out.println("4. dodaj produkt do koszyka.");
			System.out.println("5. wyswietl zawartosc koszyka");
			System.out.println("6. wyjdz.");

            String chose = in.next();
			Integer choseInt = 0;
            try {
				choseInt = Integer.parseInt(chose);
			} catch (Exception e) {
				System.out.println("you should put number");
				System.out.println(e);
				continue;
			}

            switch (choseInt) {
				case 1:
					System.out.println(productService.findAll());
					break;
				case 2:
					System.out.println("enter your name:");
					String name = in.next();
					System.out.println(productService.findByName(name));
					break;
				case 3:
					System.out.println("enter id:");
					Integer choseId = in.nextInt();
					System.out.println(productService.findById(choseId));
					break;
				case 4:
					System.out.println("chose and add product to basket");
					System.out.println(productService.findAll());
					Integer productId = in.nextInt();
					basketService.addToBasket(productId);
					break;
				case 5:
					System.out.println("your basket:");
					System.out.println(basketService.getBasket());
					break;
				case 6:
					return;
				default:
					System.out.println("wrong number");
					continue;
            }
        }
        while (true);


    }

}

