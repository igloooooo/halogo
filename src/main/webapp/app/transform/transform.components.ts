import axios from 'axios';
import Component from 'vue-class-component';
import { Vue, Inject } from 'vue-property-decorator';
import AccountService from '@/account/account.service';
@Component({})
export default class TransformForm extends Vue {
  public username = null;
  public number = null;
  public word = null;
  public authenticationError = null;

  public doConvert(): void {
    const data = { username: this.username, number: this.number };
    axios
      .post('api/transform', data)
      .then(result => {
        this.word = result.data.word;
      })
      .catch(() => {
        this.authenticationError = true;
      });
  }
}
