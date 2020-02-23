import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import axios from 'axios';
import AccountService from '@/account/account.service';
import router from '@/router';

import * as config from '@/shared/config/config';
import Transform from '@/transform/transform.vue';
import TransformClass from '@/transform/transform.components';

const localVue = createLocalVue();
localVue.component('b-alert', {});
localVue.component('b-button', {});
localVue.component('b-form', {});
localVue.component('b-form-input', {});
localVue.component('b-form-group', {});
localVue.component('b-form-checkbox', {});
localVue.component('b-link', {});
const mockedAxios: any = axios;

config.initVueApp(localVue);
const store = config.initVueXStore(localVue);

jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn()
}));

describe('Transform Component', () => {
  let wrapper: Wrapper<TransformClass>;
  let transForm: TransformClass;

  beforeEach(() => {
    mockedAxios.get.mockReset();
    mockedAxios.get.mockReturnValue(Promise.resolve({}));
    mockedAxios.post.mockReset();

    wrapper = shallowMount<TransformClass>(Transform, {
      store,
      localVue,
      provide: {
        accountService: () => new AccountService(store, router)
      }
    });
    transForm = wrapper.vm;
  });

  it('should be a Vue instance', () => {
    expect(wrapper.isVueInstance()).toBeTruthy();
  });

  it('should get converted word from backend if number is KO', async () => {
    // GIVEN
    transForm.username = 'nzhu';
    transForm.number = 123.45;
    mockedAxios.post.mockReturnValue(Promise.reject());

    // WHEN
    transForm.doConvert();
    await transForm.$nextTick();

    // THEN
    expect(mockedAxios.post).toHaveBeenCalledWith('api/transform', {
      username: 'nzhu',
      number: 123.45
    });

    expect(transForm.authenticationError).toBeTruthy();
  });
});
