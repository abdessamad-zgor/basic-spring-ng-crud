import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { count } from "rxjs";

@Injectable()
export class CountriesService {
  serviceUrl = "https://restcountries.com/v3.1/all"

  constructor(private http: HttpClient){
  }

  async getCountryNames(){
    let observable = this.http.get(this.serviceUrl)
    let countries: string[] = []

    await observable.forEach(v=>{
      //@ts-ignore
      countries.push(v.name.common)
    })

    return countries;
  }
}
