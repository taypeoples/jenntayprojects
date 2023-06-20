import axios from "axios";


export default{

    listWords(){
        return axios.get('/words');
    },

    getWordByID(id){
        return axios.get(`/words/${id}`);
    },

    getClueByPuzzleID(puzzleID){
        return axios.get(`/puzzle/${puzzleID}`);
    }
}

