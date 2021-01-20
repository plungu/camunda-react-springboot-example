// tag::vars[]
const React = require('react');
// end::vars[]

class ContactDetail extends React.Component{
  constructor(props) {
      super(props);
  }

  render(){
    return (
      <div>
        <h2>Tenant Detail</h2>
        <div>
          <ul>
            <li>{this.props.tenant.name}</li>
            <li>{this.props.tenant.email}</li>
            <li>{this.props.tenant.unitSlug}</li>
          </ul>
        </div>
      </div>
    )
  }
}

module.exports = ContactDetail;
