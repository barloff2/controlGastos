class MnHeader extends HTMLElement {
	connectedCallback() {
		this.innerHTML = `
<header>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 
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
<h1 class="font-weight-normal home-5-title mb-0">A Control de Gastos</h1>
<p class="text-white-70 mt-4 f-15 mb-0"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section> </header>`;
	}
}

customElements.define('mn-header', MnHeader);

class MnFooter extends HTMLElement {
	connectedCallback() {
		this.innerHTML = `
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