import { Component, OnInit } from '@angular/core';


declare var M: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    /*var elems = document.querySelectorAll('.carousel');
    var instances = M.Carousel.init(elems);*/
    var elems = document.querySelectorAll('.parallax');
    var instances = M.Parallax.init(elems);

    var upperCarousel = document.querySelectorAll('#upper-carousel');
    var ins1 = M.Carousel.init(upperCarousel);

    var middleCarousel = document.querySelectorAll('#middle-carousel');
    var ins2 = M.Carousel.init(middleCarousel, {fullWidth:true, indicators: true});
    //autoplay();
    //function autoplay() {
        //(<any>$('#middle-carousel')).carousel('next');
        //setTimeout(autoplay, 5500);
    //}
  }

}
