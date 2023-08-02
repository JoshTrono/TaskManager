import { Link } from "react-router-dom";

function Nav() {
    return (
        <nav className="flex justify-between items-center bg-blue-500 p-4">
            <div className="flex items-center">
                <h1 className="text-white text-xl font-bold">TaskManager</h1>
            </div>
            <ul className="flex">
                <li>
                    <Link to="/" className="text-white mx-2 hover:text-gray-200">
                        Home
                    </Link>
                </li>
                <li>
                    <Link to="/tasks" className="text-white mx-2 hover:text-gray-200">
                        Tasks
                    </Link>
                </li>
            </ul>
        </nav>
    );
}

export default Nav;