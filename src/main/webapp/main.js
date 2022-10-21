class MnHeader extends HTMLElement {
	connectedCallback() {
		this.innerHTML = ` <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registrar Ingresos</title>
    <!-- Main Header and Footer -->
    <script type=module src=main.js></script>
  
    <!-- Bootstrap only -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <!-- Bootstrap icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
      crossorigin="anonymous"></script>
  </head>
<header>
<section class="section home-5-bg" id="home">
    <div id="particles-js"></div>
    <div class="bg-overlay" style="background-color: rgba(26, 188, 156, 0.2);></div>
    <div class="home-center">
        <div class="home-desc-center">
            <div class="container">
                <div class="justify-content-center row">
                    <div class="col-lg-7">
                        <div class="mt-40 text-center home-5-content">
                            <div class="home-icon mb-4"><i class="mdi mdi-pinwheel mdi-spin text-white h1"></i></div>
<h1 id="myH2" class="font-weight-normal home-5-title mb-0 text-dark" style="font-family: sans-serif"><strong>Control de Gastos</strong></h1>
<p class="text-white-70 mt-4 f-15 mb-0"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section> 
<script>
document.getElementById("myH2").style.color = "red";
</script>
</header> <div>
<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
</svg>
</div>`;
	}
}

customElements.define('mn-header', MnHeader);

class MnFooter extends HTMLElement {
	connectedCallback() {
		this.innerHTML = `
    <div>
				<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
				</svg>
			</div>
  <footer">
  <section class="">
    <div class="container p-4 pb-0">
      <section class="nav justify-content-center border-top">
      <a href="index.html" class="nav-link px-2 text-muted">Home</a>
      </section>
    </div>
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
      © 2022 Copyright
    </div>
    </section>
  </footer>`;

	}
}

customElements.define('mn-footer', MnFooter);