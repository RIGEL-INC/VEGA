import {NgModule} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  imports: [HttpClientModule],
  exports: [HttpClientModule]
})
export class SharedModule {

}


// SharedModule Надо будет импортировать в какие то более глубокие роуты в приложении. Скорее всего это папка main
