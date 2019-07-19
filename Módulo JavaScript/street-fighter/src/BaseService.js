import axios from "axios";

export default class BaseService {

    constructor() {
        this.baseUrl = 'http://street-crescer.surge.sh/characters.json'
        this.baseUrlFlags = 'http://street-crescer.surge.sh/images/flags/'
    }

    getPersonagens(){
        return axios.get(this.baseUrl)
    }

}