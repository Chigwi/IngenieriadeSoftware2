package producto;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductControler {
	
	@PostMapping
	public String createProducto() {
		return "producto Creado";
		
	}
	
	@GetMapping
	public String getProducto() {
		return "producto obtenido";
		
	}
	
	@PutMapping
	public String updateProducto() {
		return "producto Actualizado";
		
	}
	
	@DeleteMapping
	public String deleteProducto() {
		return "producto eliminado";
		
	}
	

}
